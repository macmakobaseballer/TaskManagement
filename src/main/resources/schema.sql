CREATE TABLE IF NOT EXISTS tasks(
	task_id INT AUTO_INCREMENT,
	completed_flag BOOLEAN NOT NULL DEFAULT 0,
	task_content VARCHAR(100) NOT NULL,
	task_note VARCHAR(254),
	task_deadline DATE,
	PRIMARY KEY(task_id)
)DEFAULT CHARSET=utf8;