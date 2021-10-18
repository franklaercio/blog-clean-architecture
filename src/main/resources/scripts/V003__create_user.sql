CREATE TABLE public.users (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   person_id UUID NOT NULL,
   username VARCHAR(256),
   password VARCHAR(256),
   user_type INTEGER,
   status INTEGER,
   created_at TIMESTAMP,
   update_at TIMESTAMP,
   CONSTRAINT fk_person_id FOREIGN KEY(person_id) REFERENCES person(id)
);