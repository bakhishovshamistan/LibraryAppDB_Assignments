
-- US 01
select * from users; --
-- 1855

select count(distinct id) from users;
-- 1855


-- RESULT --> MANUALLY IT IS PASSED


-- US 02
select * from users;



-- US 03
select count(*) from book_borrow
where is_returned=0;

-- Us 05
SELECT bc.name, count(*) from book_borrow bb
                                  inner join books b on bb.book_id = b.id
                                  inner join book_categories bc on b.book_category_id = bc.id
group by name
order by 2 desc;
