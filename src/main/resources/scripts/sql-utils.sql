select * from machine_time_series
select * from machine;

select * from sensor         

select * from room;

select * from motherboard;
select * from middleware

select count(*) from machine
delete from machine;
select count(*) from sensor;
delete from sensor;
commit;


select 27466 - count(*) from sensor;

select * from sensor where lower(sensor_name) like '%power%'

select count(*) from time_series;
select count(*) from time_series_acquisition;
select count(*) from machine_time_series;

select 
   (select count(*) from time_series) as times_series, 
   (select count(*) from time_series_acquisition) as time_series_acquisitions,
   (select count(*) from machine_time_series) machine_time_series,
   (select count(*) from room_time_series) room_time_series,
   current_timestamp
;


select FROM_UNIXTIME(tsa.ts), value from time_series_acquisition tsa

select * from vw_machine_time_series where lower(sensor_name) like 'cpu_idle'

select * from vw_machine_time_series where lower(sensor_name) like '%t%'

select * from time_series_acquisition where time_series_id = 1848


select * from vw_machine_time_series where sensor_id in (select sensor_id from sensor where lower(sensor_name) like '%T%')



alter table time_series_acquisition 
  change column value value decimal (65,30)

select * from machine_time_series

delete from room_time_series;
delete from machine_time_series;
delete from time_series_acquisition;
delete from time_series;


select distinct sensor_name from vw_machine_time_series
select distinct (sensor_name) from vw_machine_time_series where lower(sensor_name) = '%t%'  order by sensor_name asc 

-- Warning:   Data truncated for column 'value' at row 192021

select cast(1351814400 * 1000 as datetime(1351814400, seconds))

select FROM_UNIXTIME(1351814400)
