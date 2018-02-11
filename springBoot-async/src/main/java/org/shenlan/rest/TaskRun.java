package org.shenlan.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.shenlan.async.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskRun {

	@Autowired
	Task task;

	@RequestMapping("/asynctask")
	@ResponseBody
	public List<Object> test() throws Exception {
		long start = System.currentTimeMillis();

		Future<String> task1 = task.doTaskOne();
		Future<String> task2 = task.doTaskTwo();
		Future<String> task3 = task.doTaskThree();
		Future<String> task4 = task.doTaskFour();

		List<Object> listFuture = new ArrayList<Object>();
		while (true) {
			if (task4.isDone() && task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				listFuture.add(task1.get());
				listFuture.add(task2.get());
				listFuture.add(task3.get());
				listFuture.add(task4.get());

				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();
		listFuture.add("任务全部完成，总耗时：" + (end - start) + "毫秒");

		return listFuture;
	}

}
