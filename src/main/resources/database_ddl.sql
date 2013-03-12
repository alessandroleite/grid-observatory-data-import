--
-- Copyright (C) 2013 Alessandro <alessandro dot leite at alessandro dot cc>
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--         http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

create table sensor(
  sensor_id bigint unsigned not null primary key,
  sensor_name varchar(120) not null,
  acquisition_tool_type varchar(60) not null,
  unit varchar(30) not null
);
-- insert into sensor (sensor_id, sensor_name, acquisition_tool_type, unit) values (?,?,?,?)

create table motherboard (
 motherboard_id bigint unsigned not null primary key,
 product_manufacturer varchar(150),
 product_name varchar(150),
 port_number varchar(20),
 board_serial varchar(60),
 board_manufacturing varchar(120),
 board_product varchar(150),
 manufacturing_date varchar(60),
 date_from timestamp not null
);

-- insert into motherboard (motherboard_id, product_manufacturer, product_name, port_number, board_serial, board_manufacturing, board_product, manufacturing_date, date_from) values (?,?,?,?,?,?,?,?,?)

create table middleware (
	middleware_id bigint unsigned not null primary key,
	middleware_type varchar(30) not null,
	product_name varchar(200) not null,
	product_version varchar(120),
	kernel_name varchar(120),
	kernel_version varchar(120),
	arch varchar(120)
);

-- insert into middleware (middleware_id,middleware_type,product_name,product_version,kernel_name,kernel_version,arch) values (?,?,?,?,?,?)

create table room (
  room_id bigint unsigned not null primary key,
  date_created timestamp not null
);

-- insert into room (room_id, date_created) values (?,?)

create table machine (
  machine_id bigint unsigned not null primary key,
  room_id bigint unsigned not null references room(room_id),
  motherboard_id bigint unsigned not null references motherboard(motherboard_id),
  middleware_id bigint unsigned not null references middleware(middleware_id),
  date_created timestamp not null,
  date_retired timestamp  
);

-- insert into machine (machine_id, room_id, motherboard_id, middleware_id, date_created, date_retired) values (?,?,?,?,?,?)

create table time_series (
  time_series_id bigint unsigned not null auto_increment primary key,
  constant_value varchar(60), 
  start_date timestamp not null,
  end_date timestamp not null,
  acquisition_count bigint unsigned not null
 );
 
 -- insert into time_series (time_series_id, constant_value,start_date,end_date,acquisition_count ) values (?,?,?,?,?)
 
 create table machine_time_series (
   time_series_id bigint unsigned not null primary key references time_series (time_series_id),
   machine_id bigint unsigned not null references machine (machine_id),
   sensor_id bigint unsigned not null references sensor (sensor_id)
 );
 
 -- insert into machine_time_series (time_series_id, machine_id, sensor_id) values (?,?, ?)
 
 create table room_time_series (
   time_series_id bigint unsigned not null primary key references time_series (time_series_id),
   room_id bigint unsigned not null references room (room_id),
   sensor_id bigint unsigned not null references sensor (sensor_id)
 );
 
 -- insert into room_time_series (time_series_id, room_id, sensor_id) values (?, ?, ?)
