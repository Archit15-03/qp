-- SEQUENCE: public.grocery_sequence

-- DROP SEQUENCE IF EXISTS public.grocery_sequence;

CREATE SEQUENCE IF NOT EXISTS public.grocery_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 1000000
    CACHE 10;

ALTER SEQUENCE public.grocery_sequence
    OWNER TO postgres;