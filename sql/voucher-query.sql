-- VOUCHER

UPDATE payment.m_vouchers SET activedate = NULL, assignto = NULL, isussed = 0;

UPDATE payment.m_vouchers SET productcode = 'P0001';

SELECT code, count(code) FROM payment.m_vouchers mv GROUP BY code HAVING count(code) > 1;

SELECT code FROM payment.m_vouchers mv WHERE date = 20200611 and productcode = 'P0003'; 