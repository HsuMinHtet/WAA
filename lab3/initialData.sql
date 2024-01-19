-- Insert sample data for User table with associated posts
INSERT INTO user (name) VALUES ('User1');

-- Get the generated ID for the user
SET @userId := LAST_INSERT_ID();

-- Associate posts with the user
INSERT INTO post (title, content, author, id_user) VALUES
                                                       ('First Post', 'Content of the first post', 'Author1', @userId),
                                                       ('Second Post', 'Content of the second post', 'Author2', @userId);
