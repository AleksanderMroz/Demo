
insert into CUSTOMER (customer_name,password,address) values ("Aleksander","user1","MOSCOW");
insert into CUSTOMER (customer_name,password,address) values ("Bolek","user2","WARSAW");
insert into CUSTOMER (customer_name,password,address) values ("Czarek","user3","WROCLAW");

insert into OUTPOST  (logo, location) values ("DHL-1","WROCLAW");
insert into OUTPOST  (logo, location) values ("DHL-2","MOSCOW");
insert into OUTPOST  (logo, location) values ("DHL-3","WARSAW");
insert into OUTPOST  (logo, location) values ("DHL-4","PARIS");
insert into OUTPOST  (logo, location) values ("DHL-5","ROME");
insert into OUTPOST  (logo, location) values ("DHL-6","PRAGA");

insert into SHIPMENT (value,status,start_outpost,current_outpost,end_outpost,id_owner) values (1001,"TRANSPORT",5,2,1,3);
insert into SHIPMENT (value,status,start_outpost,current_outpost,end_outpost,id_owner) values (1006,"TRANSPORT",5,2,3,3);
insert into SHIPMENT (value,status,start_outpost,current_outpost,end_outpost,id_owner) values (1002,"PREPARED",5,5,2,1);
insert into SHIPMENT (value,status,start_outpost,current_outpost,end_outpost,id_owner) values (1003,"TRANSPORT",5,4,2,1);
insert into SHIPMENT (value,status,start_outpost,current_outpost,end_outpost,id_owner) values (1004,"DELIVERED",5,3,3,2);
insert into SHIPMENT (value,status,start_outpost,current_outpost,end_outpost,id_owner) values (1005,"TRANSPORT",5,2,3,2);




insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"M","STANDARD",1);

insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"S","STANDARD",2);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"L","STANDARD",2);

insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"XS","FLAT",3);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"M","STANDARD",3);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"XL","STANDARD",3);

insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"XS","FLAT",4);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"S","FLAT",4);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"L","STANDARD",4);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"XL","CUSTOMSHAPE",4);

insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"XS","FLAT",5);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"XS","FLAT",5);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"M","STANDARD",5);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"M","STANDARD",5);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"XL","CUSTOMSHAPE",5);

insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"XS","FLAT",6);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"M","FLAT",6);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"L","STANDARD",6);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"L","STANDARD",6);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"XL","STANDARD",6);
insert into PRODUCT (value,size_Status,variant_Status,id_shipment) values (1000,"XL","CUSTOMSHAPE",6);




insert into OPINION(description,id_product,id_customer) values ("Not bad at all",1,1);
insert into OPINION(description,id_product,id_customer) values ("Not bad at all",2,1);
insert into OPINION(description,id_product,id_customer) values ("Not bad at all",3,1);
insert into OPINION(description,id_product,id_customer) values ("Not bad at all",4,1);
insert into OPINION(description,id_product,id_customer) values ("Not bad at all",5,1);

insert into OPINION(description,id_product,id_customer) values ("Not bad at all",1,2);
insert into OPINION(description,id_product,id_customer) values ("Not bad at all",2,2);
insert into OPINION(description,id_product,id_customer) values ("Not bad at all",3,2);




insert into COURIER(courier_name,password,address) values ("Adam","user4","ul.Somewhere")
insert into COURIER(courier_name,password,address) values ("Bartek","user5","ul.Somewhere")
insert into COURIER(courier_name,password,address) values ("Mariusz","user6","ul.Somewhere")

insert into COURIER_SHIPMENT(courier_id,shipment_id) values(1,1);
insert into COURIER_SHIPMENT(courier_id,shipment_id) values(2,1);
insert into COURIER_SHIPMENT(courier_id,shipment_id) values(1,2);
insert into COURIER_SHIPMENT(courier_id,shipment_id) values(2,2);

