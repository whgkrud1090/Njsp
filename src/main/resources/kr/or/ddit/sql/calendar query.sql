--년월값을 파라미터로 받는다 "201908"
--sql select 결과는 해당 년월의 달력을 만들어주는 쿼리

--level은 1부터 시작
select add_months(to_date('201902', 'yyyyMM'), 1) - to_date('201902', 'yyyyMM')
from dual;

--d : 1 일요일, 2 월요일, 3 화요일.....7 토요일
select iw, min(sun), min(mon), min(tue), min(wed), min(thu), min(fri), min(sat)
from
(select dt, --to_char(dt, 'w') w,
        --to_char(dt, 'ww') ww,
        --to_char(dt, 'iw') iw,
        decode(to_char(dt, 'd'), 1, to_char(dt, 'iw')+1, to_char(dt, 'iw')) iw,
        to_char(dt, 'd') d,
        decode(to_char(dt, 'd'), 1, dt) sun, 
        decode(to_char(dt, 'd'), 2, dt) mon, 
        decode(to_char(dt, 'd'), 3, dt) tue, 
        decode(to_char(dt, 'd'), 4, dt) wed, 
        decode(to_char(dt, 'd'), 5, dt) thu, 
        decode(to_char(dt, 'd'), 6, dt) fri, 
        decode(to_char(dt, 'd'), 7, dt) sat
 from 
(select level, to_date('201910', 'yyyyMM') + (level-1) dt --날짜타입 + 정수 : 일자연산
from dual
connect by level <= add_months(to_date('201910', 'yyyyMM'), 1) - to_date('201910', 'yyyyMM')))
group by iw
order by iw;

--add_months(to_date('201910', 'yyyyMM'), 1) - to_date('201910', 'yyyyMM'))


select iw, min(sun), min(mon), min(tue), min(wed), min(thu), min(fri), min(sat)
from
(select dt, 
        decode(to_char(dt, 'd'), 1, to_char(dt, 'iw')+1, to_char(dt, 'iw')) iw,
        to_char(dt, 'd') d,
        decode(to_char(dt, 'd'), 1, dt) sun, 
        decode(to_char(dt, 'd'), 2, dt) mon, 
        decode(to_char(dt, 'd'), 3, dt) tue, 
        decode(to_char(dt, 'd'), 4, dt) wed, 
        decode(to_char(dt, 'd'), 5, dt) thu, 
        decode(to_char(dt, 'd'), 6, dt) fri, 
        decode(to_char(dt, 'd'), 7, dt) sat
 from 
(select level, to_date('201910', 'yyyyMM') - to_number(to_char(to_date('201910', 'yyyyMM'), 'd')) + level dt --날짜타입 + 정수 : 일자연산
from dual
connect by level <= add_months(to_date('201910', 'yyyyMM'), 1)-1 +(7-to_char(add_months(to_date('201910', 'yyyyMM'), 1)-1, 'd'))
     - (to_date('201910', 'yyyyMM') - to_char(to_date('201910', 'yyyyMM'), 'd'))))
group by iw
order by iw;


select (to_date('201910', 'yyyyMM') - to_char(to_date('201910', 'yyyyMM'), 'd')) s,
    add_months(to_date('201910', 'yyyyMM'), 1)-1 +(7-to_char(add_months(to_date('201910', 'yyyyMM'), 1)-1, 'd'))t,

add_months(to_date('201910', 'yyyyMM'), 1)-1 +(7-to_char(add_months(to_date('201910', 'yyyyMM'), 1)-1, 'd'))
     - (to_date('201910', 'yyyyMM') - to_char(to_date('201910', 'yyyyMM'), 'd')) ts
from dual;     




