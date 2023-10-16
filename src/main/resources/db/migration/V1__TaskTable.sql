CREATE TABLE task (
    task_id UUID NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    finish_date DATE,
    creation_date DATE
)