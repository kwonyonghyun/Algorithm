with firstGen as (
    select id
    from ecoli_data
    where parent_id IS NULL
),
secondGen as (
    select id
    from ecoli_data
    where parent_id in (select * from firstGen)
)

select id
from ecoli_data
where parent_id in (select * from secondGen);

-- 실패 (1064, "You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 5")