CREATE TABLE public.posts (
   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
   author VARCHAR(256),
   title VARCHAR(256),
   subtitle VARCHAR(256),
   content TEXT,
   allow_comment BOOLEAN,
   allow_ping BOOLEAN,
   allow_feed BOOLEAN,
   url VARCHAR(256),
   status INTEGER,
   created_at TIMESTAMP,
   update_at TIMESTAMP
);