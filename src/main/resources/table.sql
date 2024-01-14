-- Table: public.grocery

-- DROP TABLE IF EXISTS public.grocery;

CREATE TABLE IF NOT EXISTS public.grocery
(
    id integer NOT NULL,
    price double precision,
    quantity integer NOT NULL,
    grocery_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT grocery_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.grocery
    OWNER to postgres;