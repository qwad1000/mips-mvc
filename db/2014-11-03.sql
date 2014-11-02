

CREATE SEQUENCE mips.public.lab_id_seq;

CREATE TABLE mips.public.lab (
                id INTEGER NOT NULL DEFAULT nextval('mips.public.lab_id_seq'),
                variant_id INTEGER NOT NULL,
                lab_bundle_id INTEGER NOT NULL,
                number VARCHAR(8) NOT NULL,
                name VARCHAR(128) NOT NULL,
                deadline DATE,
                description VARCHAR(512) NOT NULL,
                max_point INTEGER NOT NULL,
                CONSTRAINT lab_pk PRIMARY KEY (id)
);


ALTER SEQUENCE mips.public.lab_id_seq OWNED BY mips.public.lab.id;

CREATE SEQUENCE mips.public.lab_bundle_id_seq;

CREATE TABLE mips.public.lab_bundle (
                id INTEGER NOT NULL DEFAULT nextval('mips.public.lab_bundle_id_seq'),
                descriprion VARCHAR NOT NULL,
                CONSTRAINT lab_bundle_pk PRIMARY KEY (id)
);


ALTER SEQUENCE mips.public.lab_bundle_id_seq OWNED BY mips.public.lab_bundle.id;

CREATE SEQUENCE mips.public.student_id_seq;

CREATE TABLE mips.public.student (
                id INTEGER NOT NULL DEFAULT nextval('mips.public.student_id_seq'),
                name VARCHAR(255) NOT NULL,
                group_id INTEGER NOT NULL,
                user_id INTEGER NOT NULL,
                CONSTRAINT student_pk PRIMARY KEY (id)
);


ALTER SEQUENCE mips.public.student_id_seq OWNED BY mips.public.student.id;

CREATE SEQUENCE mips.public.students_group_id_seq;

CREATE TABLE mips.public.students_group (
                id INTEGER NOT NULL DEFAULT nextval('mips.public.students_group_id_seq'),
                name VARCHAR(16) NOT NULL,
                CONSTRAINT students_group_pk PRIMARY KEY (id)
);


ALTER SEQUENCE mips.public.students_group_id_seq OWNED BY mips.public.students_group.id;

CREATE SEQUENCE mips.public.submit_try_id_seq;

CREATE TABLE mips.public.submit_try (
                id INTEGER NOT NULL DEFAULT nextval('mips.public.submit_try_id_seq'),
                variant_id INTEGER NOT NULL,
                student_id INTEGER NOT NULL,
                time TIME NOT NULL,
                points REAL DEFAULT 0 NOT NULL,
                teacher_checked BOOLEAN NOT NULL,
                test_passed INTEGER DEFAULT 0 NOT NULL,
                CONSTRAINT submit_try_pk PRIMARY KEY (id)
);


ALTER SEQUENCE mips.public.submit_try_id_seq OWNED BY mips.public.submit_try.id;

CREATE SEQUENCE mips.public.test_id_seq;

CREATE TABLE mips.public.test (
                id INTEGER NOT NULL DEFAULT nextval('mips.public.test_id_seq'),
                variant_id INTEGER NOT NULL,
                body VARCHAR NOT NULL,
                result VARCHAR NOT NULL,
                CONSTRAINT test_pk PRIMARY KEY (id)
);


ALTER SEQUENCE mips.public.test_id_seq OWNED BY mips.public.test.id;

CREATE SEQUENCE mips.public.variant_id_seq_1;

CREATE TABLE mips.public.variant (
                id INTEGER NOT NULL DEFAULT nextval('mips.public.variant_id_seq_1'),
                mission VARCHAR NOT NULL,
                CONSTRAINT variant_pk PRIMARY KEY (id)
);


ALTER SEQUENCE mips.public.variant_id_seq_1 OWNED BY mips.public.variant.id;

ALTER TABLE mips.public.lab ADD CONSTRAINT lab_bundle_lab_fk
FOREIGN KEY (lab_bundle_id)
REFERENCES mips.public.lab_bundle (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE mips.public.submit_try ADD CONSTRAINT student_submit_try_fk
FOREIGN KEY (student_id)
REFERENCES mips.public.student (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE mips.public.student ADD CONSTRAINT group_student_fk
FOREIGN KEY (group_id)
REFERENCES mips.public.students_group (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE mips.public.student ADD CONSTRAINT users_student_fk
FOREIGN KEY (user_id)
REFERENCES mips.public.users (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE mips.public.lab ADD CONSTRAINT variant_lab_fk
FOREIGN KEY (variant_id)
REFERENCES mips.public.variant (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE mips.public.submit_try ADD CONSTRAINT variant_submit_try_fk
FOREIGN KEY (variant_id)
REFERENCES mips.public.variant (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE mips.public.test ADD CONSTRAINT variant_test_fk
FOREIGN KEY (variant_id)
REFERENCES mips.public.variant (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
