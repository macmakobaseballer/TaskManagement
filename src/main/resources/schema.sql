use task_management;

create table if not exists task_management.tasks(
	task_id int auto_increment,
	completed_flag boolean not null default 0,
	task_content varchar(100) not null,
	task_note varchar(254),
	task_deadline date,
	primary key(task_id)
)default charset=utf8;