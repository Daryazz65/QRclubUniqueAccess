INSERT INTO participants (first_name, last_name, middle_name) VALUES
                                                                  ('Иван', 'Иванов', 'Иванович'),
                                                                  ('Пётр', 'Петров', 'Петрович'),
                                                                  ('Сергей', 'Сидоров', 'Сергеевич');

INSERT INTO qr_codes (participant_id, qr_uuid) VALUES
                                                   (1, 'a1b2c3d4-e5f6-7890-abcd-ef1234567890'),
                                                   (2, 'b2c3d4e5-f6a7-8901-bcde-f12345678901'),
                                                   (3, 'c3d4e5f6-a7b8-9012-cdef-123456789012');