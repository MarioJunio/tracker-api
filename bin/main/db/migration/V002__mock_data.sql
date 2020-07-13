insert into launch(id, type, unit_type, value) 
values 
(1, 'speed', 'km_h', 90), 
(2, 'distance', 'km', 7);

insert into track(id, speed, distance, accuracy, timer, launch_id, version) 
values 
(1, 90, 110, 4.9, 3400, 1, 0), 
(2, 110, 7000, 4.97, 240000, 2, 0);