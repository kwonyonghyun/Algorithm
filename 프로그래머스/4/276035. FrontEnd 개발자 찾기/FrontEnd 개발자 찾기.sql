select distinct(id), email, first_name, last_name
from developers
join skillcodes on developers.skill_code&skillcodes.code = skillcodes.code
where category = 'Front End'
order by id
;