
INSERT INTO "ucesnik"("id", "ime", "prezime", "mbr", "status")
VALUES(nextval('ucesnik_seq'), 'Milos', 'Lukic', '0808998855146', 'U procesu');
INSERT INTO "ucesnik"("id", "ime", "prezime", "mbr", "status")
VALUES(nextval('ucesnik_seq'), 'Radivoj', 'Kuruca', '0101001899146', 'Predao zahtev');
INSERT INTO "ucesnik"("id", "ime", "prezime", "mbr", "status")
VALUES(nextval('ucesnik_seq'), 'Uros', 'Aleksic', '0102002811162', 'Gotov');
INSERT INTO "ucesnik"("id", "ime", "prezime", "mbr", "status")
VALUES(nextval('ucesnik_seq'), 'Pera', 'Peric', '0301992899546', 'U procesu');
INSERT INTO "ucesnik"("id", "ime", "prezime", "mbr", "status")
VALUES(nextval('ucesnik_seq'), 'Mita', 'Mitic', '1404992666444', 'Gotov');
INSERT INTO "ucesnik"("id", "ime", "prezime", "mbr", "status")
VALUES(nextval('ucesnik_seq'), 'Jovan', 'Jovanovic', '0808998489159', 'U procesu');


INSERT INTO "sud"("id", "naziv", "adresa")
VALUES (nextval('sud_seq'), 'Osnovi sud', 'Sutjeska 3');
INSERT INTO "sud"("id", "naziv", "adresa")
VALUES (nextval('sud_seq'), 'Apelacioni sud', 'Sutjeska 3');
INSERT INTO "sud"("id", "naziv", "adresa")
VALUES (nextval('sud_seq'), 'Visi sud', 'Sutjeska 3');
INSERT INTO "sud"("id", "naziv", "adresa")
VALUES (nextval('sud_seq'), 'Privredni apelacioni sud', 'Sutjeska 3');
INSERT INTO "sud"("id", "naziv", "adresa")
VALUES (nextval('sud_seq'), 'Upravni sud', 'Sutjeska 3');
INSERT INTO "sud"("id", "naziv", "adresa")
VALUES (nextval('sud_seq'), 'Prekrsajni apelacioni sud', 'Sutjeska 3');
INSERT INTO "sud"("id", "naziv", "adresa")
VALUES (nextval('sud_seq'), 'Prekrsajni sud', 'Sutjeska 3');



INSERT INTO "predmet"("id", "broj_pr", "opis", "datum_pocetka", "aktivan", "sud")
VALUES (nextval('predmet_seq'), 23568, 'Razbojnistvo', TO_DATE('01.04.2023', 'dd.mm.yyyy'), FALSE, 3);
INSERT INTO "predmet"("id", "broj_pr", "opis", "datum_pocetka", "aktivan", "sud")
VALUES (nextval('predmet_seq'), 23567, 'Saobracajna nesreca', TO_DATE('01.05.2023', 'dd.mm.yyyy'), TRUE, 2);
INSERT INTO "predmet"("id", "broj_pr", "opis", "datum_pocetka", "aktivan", "sud")
VALUES (nextval('predmet_seq'), 23566, 'Kradja', TO_DATE('01.06.2023', 'dd.mm.yyyy'), TRUE, 3);
INSERT INTO "predmet"("id", "broj_pr", "opis", "datum_pocetka", "aktivan", "sud")
VALUES (nextval('predmet_seq'), 23565, 'Unistavanje imovine', TO_DATE('01.07.2023', 'dd.mm.yyyy'), TRUE, 4);

INSERT INTO "rociste"("id", "datum_rocista", "sudnica", "predmet", "ucesnik")
VALUES (NEXTVAL('rociste_seq'), TO_DATE('15.04.2023', 'dd.mm.yyyy'), '12A4', 1, 1);
INSERT INTO "rociste"("id", "datum_rocista", "sudnica", "predmet", "ucesnik")
VALUES (NEXTVAL('rociste_seq'), TO_DATE('15.04.2023', 'dd.mm.yyyy'), '12B4', 2, 2);
INSERT INTO "rociste"("id", "datum_rocista", "sudnica", "predmet", "ucesnik")
VALUES (NEXTVAL('rociste_seq'), TO_DATE('26.05.2023', 'dd.mm.yyyy'), '12C4', 3, 2);
INSERT INTO "rociste"("id", "datum_rocista", "sudnica", "predmet", "ucesnik")
VALUES (NEXTVAL('rociste_seq'), TO_DATE('18.05.2023', 'dd.mm.yyyy'), '12A4', 4, 3);
INSERT INTO "rociste"("id", "datum_rocista", "sudnica", "predmet", "ucesnik")
VALUES (NEXTVAL('rociste_seq'), TO_DATE('06.06.2023', 'dd.mm.yyyy'), '12B4', 2, 4);