CREATE TABLE public.person (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   name VARCHAR(256),
   email VARCHAR(256),
   created_at TIMESTAMP,
   update_at TIMESTAMP
);