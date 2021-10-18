CREATE TABLE public.comment (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   person_name VARCHAR(256),
   person_email VARCHAR(256),
   content TEXT,
   created_at TIMESTAMP,
   update_at TIMESTAMP
);