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


select * from machine_time_series

delete from room_time_series;
delete from machine_time_series;
delete from time_series_acquisition;
delete from time_series;


select distinct sensor_name from vw_machine_time_series
select distinct (sensor_name) from vw_machine_time_series where lower(sensor_name) = '%t%'  order by sensor_name asc 

