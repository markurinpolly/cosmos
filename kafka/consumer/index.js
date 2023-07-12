const ip = require('ip')

const { Kafka, logLevel } = require('kafkajs')

const host = process.env.HOST_IP || ip.address()

const kafka = new Kafka({
  logLevel: logLevel.NOTHING,
  brokers: [`${host}:9092`],
  clientId: `example-consumer-${process.env.pm_id}`,
})

console.log(`🚀 ~ file: index.js:15 ~ process.env.pm_id:`, process.env.pm_id);

const topics = [`topic-test-${process.env.pm_id}`];
// const topics = [`topic-test-1`];

// if(process.env.pm_id == 1) {
//   var topics = [`topic-test-1`, `topic-test-2`];
// } else {
//   var topics = [`topic-test-1`];
// }

const consumer = kafka.consumer({ groupId: `test-group-${process.env.pm_id}` })

const run = async () => {
  await consumer.connect()
  await consumer.subscribe({ topics, fromBeginning: true })
  await consumer.run({
    // eachBatch: async ({ batch }) => {
    //   console.log(batch)
    // },
    eachMessage: async ({ topic, partition, message }) => {
      const prefix = `${topic}[${partition} | ${message.offset}]`

      const obj = JSON.parse(message.value);

      console.log(`- ${prefix} ${message.key}#${obj.docno}#${obj.description}#pm_id:${obj.pm_id}`)
    },
  })
}

run().catch(e => console.error(`[example/consumer] ${e.message}`, e))

const errorTypes = ['unhandledRejection', 'uncaughtException']
const signalTraps = ['SIGTERM', 'SIGINT', 'SIGUSR2']

errorTypes.forEach(type => {
  process.on(type, async e => {
    try {
      console.log(`process.on ${type}`)
      console.error(e)
      await consumer.disconnect()
      process.exit(0)
    } catch (_) {
      process.exit(1)
    }
  })
})

signalTraps.forEach(type => {
  process.once(type, async () => {
    try {
      await consumer.disconnect()
    } finally {
      process.kill(process.pid, type)
    }
  })
})