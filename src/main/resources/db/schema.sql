/* タスクテーブル */
CREATE TABLE IF NOT EXISTS t_task (
  id INT PRIMARY KEY,
  user_id VARCHAR(50),
  title VARCHAR(50),
  limit_day DATE,
  complete BOOLEAN
);