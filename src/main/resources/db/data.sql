/* 開発用にデータ削除を追加 : リリース時は消す */
DELETE FROM t_task;

/* タスクテーブルのデータ */
INSERT INTO t_task (id, user_id, title, limit_day, complete) VALUES (1, 'admin', '主キーのカウントアップのため、このレコードは消さないこと', '2023-06-26', true);
INSERT INTO t_task (id, user_id, title, limit_day, complete) VALUES (2, 'user', '食材を購入するためのリストを作成', '2023-06-27', false);
INSERT INTO t_task (id, user_id, title, limit_day, complete) VALUES (3, 'user', '明日の夕食にレストランを予約しているので、確認の電話をかける', '2023-07-11', false);
INSERT INTO t_task (id, user_id, title, limit_day, complete) VALUES (4, 'user', '近所のスポーツクラブに登録するため、必要な書類と登録費用を準備する', '2024-02-27', false);