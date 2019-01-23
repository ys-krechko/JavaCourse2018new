package homework.task30;

/*Напишите запрос, делающей выборку из обеих таблиц полей, где величина расходов больше 10000.
В выборке должны присутствовать четыре поля: номер платежа, дата, имя получателя, величина.*/

/*
SELECT e.num, e.paydate, r.receiver, e.value
FROM expenses AS e, receiver AS r
WHERE e.value > 10000 ORDERED BY e.value DESC;
*/
