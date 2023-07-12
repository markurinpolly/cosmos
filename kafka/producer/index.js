const ip = require('ip')

const { Kafka, CompressionTypes, logLevel } = require('kafkajs')

const host = process.env.HOST_IP || ip.address()

const kafka = new Kafka({
  logLevel: logLevel.NOTHING,
  brokers: [`${host}:9092`],
  clientId: 'example-producer',
})

const topic = 'topic-test'
const producer = kafka.producer()

var number = 0;

const createMessage = (pm_id, num) => ({
  key: `key-${num}`,
  value: JSON.stringify({
    docno: `docno-${num}`,
    description: `description-${num}`,
    pm_id
  }),
});

var pm_id = 1;

const sendMessage = () => {
  if(pm_id == 1) {
    pm_id = 2;
  } else {
    pm_id = 1;
  }
  
  var tmp_topic = `${topic}-${pm_id}`;
  // var tmp_topic = `${topic}`;

  const messages = [createMessage(pm_id, number++)];
  
  console.log(`🚀 ~ file: index.js:25 ~ sendMessage ~ ${tmp_topic} | ${JSON.parse(messages[0]["value"])["docno"]}`);

  return producer
    .send({
      topic: `${tmp_topic}`,
      compression: CompressionTypes.GZIP,
      messages,
    })
    // .then(console.log)
    .catch(e => console.error(`[example/producer] ${e.message}`, e))
}

const run = async () => {
  await producer.connect()
  setInterval(sendMessage, 1000)
}

run().catch(e => console.error(`[example/producer] ${e.message}`, e))

const errorTypes = ['unhandledRejection', 'uncaughtException']
const signalTraps = ['SIGTERM', 'SIGINT', 'SIGUSR2']

errorTypes.forEach(type => {
  process.on(type, async () => {
    try {
      console.log(`process.on ${type}`)
      await producer.disconnect()
      process.exit(0)
    } catch (_) {
      process.exit(1)
    }
  })
})

signalTraps.forEach(type => {
  process.once(type, async () => {
    try {
      await producer.disconnect()
    } finally {
      process.kill(process.pid, type)
    }
  })
})