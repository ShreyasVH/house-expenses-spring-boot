ALTER TABLE expense drop CONSTRAINT expense_fk_category;
ALTER TABLE expense drop CONSTRAINT expense_fk_sub_category;
ALTER TABLE expense drop CONSTRAINT expense_fk_company;

ALTER TABLE expense DROP COLUMN category_id;
ALTER TABLE expense DROP COLUMN sub_category_id;
ALTER TABLE expense DROP COLUMN company_id;
ALTER TABLE expense DROP COLUMN bill;
ALTER TABLE expense DROP COLUMN bill_date;

CREATE SEQUENCE IF NOT EXISTS public.bill_id_seq;
CREATE TABLE public.bill
(
    id bigint NOT NULL DEFAULT nextval('bill_id_seq'::regclass),
    name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    amount integer NOT NULL,
    bill_doc character varying(512) COLLATE pg_catalog."default" NOT NULL,
    bill_date date NOT NULL,
    category_id smallint NOT NULL,
    sub_category_id smallint NOT NULL,
    company_id smallint NOT NULL,
    CONSTRAINT bill_pkey PRIMARY KEY (id),
    CONSTRAINT bill_fk_category FOREIGN KEY (category_id) REFERENCES public.category (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT bill_fk_sub_category FOREIGN KEY (sub_category_id) REFERENCES public.sub_category (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT bill_fk_company FOREIGN KEY (company_id) REFERENCES public.company (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER TABLE expense ADD COLUMN bill_id smallint;
ALTER TABLE expense ADD CONSTRAINT expense_fk_bill FOREIGN KEY (bill_id) REFERENCES public.bill (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;