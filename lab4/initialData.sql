-- Insert sample data for User table with associated posts
WITH inserted_user AS (
    INSERT INTO users (name) VALUES ('User1') RETURNING id
)
-- Associate posts with the user
INSERT INTO post (title, content, author, id_user)
VALUES
    ('First Post', 'Content of the first post', 'Author1', (SELECT id FROM inserted_user)),
    ('Second Post', 'Content of the second post', 'Author2', (SELECT id FROM inserted_user));


INSERT INTO comment (name,id_post) VALUES
                               ('Comment1',1),
                               ('Comment2',1);
