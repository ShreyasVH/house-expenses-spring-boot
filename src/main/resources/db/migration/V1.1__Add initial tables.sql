CREATE SEQUENCE IF NOT EXISTS public.category_id_seq;
CREATE TABLE public.category
(
    id bigint NOT NULL DEFAULT nextval('category_id_seq'::regclass),
    name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT category_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.sub_category_id_seq;
CREATE TABLE public.sub_category
(
    id bigint NOT NULL DEFAULT nextval('sub_category_id_seq'::regclass),
    name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT sub_category_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.company_id_seq;
CREATE TABLE public.company
(
    id bigint NOT NULL DEFAULT nextval('company_id_seq'::regclass),
    name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.expense_id_seq;
CREATE TABLE public.expense
(
    id bigint NOT NULL DEFAULT nextval('expense_id_seq'::regclass),
    name character varying(25) COLLATE pg_catalog."default" NOT NULL,
    amount integer NOT NULL,
    bill character varying(512) COLLATE pg_catalog."default" NOT NULL,
    bill_date date NOT NULL,
    receipt character varying(512) COLLATE pg_catalog."default" NOT NULL,
    receipt_date date NOT NULL,
    payer character varying(25) COLLATE pg_catalog."default" NOT NULL,
    mode character varying(25) COLLATE pg_catalog."default" NOT NULL,
    category_id smallint NOT NULL,
    sub_category_id smallint NOT NULL,
    company_id smallint NOT NULL,
    CONSTRAINT expense_pkey PRIMARY KEY (id),
    CONSTRAINT expense_fk_category FOREIGN KEY (category_id) REFERENCES public.category (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT expense_fk_sub_category FOREIGN KEY (sub_category_id) REFERENCES public.sub_category (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT expense_fk_company FOREIGN KEY (company_id) REFERENCES public.company (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);