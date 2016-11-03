package com.sohan.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {

	private static final long serialVersionUID = 1L;
	private final String path;
	private final String extension;

	public FolderProcessor(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}

	@Override
	protected List<String> compute() {
		List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
		List<String> fileList = new ArrayList<String>();
		File f = new File(path);
		File[] files = f.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					FolderProcessor task = new FolderProcessor(file.getAbsolutePath(), extension);
					task.fork();
					tasks.add(task);
				} else {
					if (file.getName().endsWith(extension)) {
						fileList.add(file.getAbsolutePath());
					}
				}
			}
		}

		addResultsFromSubTasks(tasks, fileList);
		return fileList;
	}

	private void addResultsFromSubTasks(List<FolderProcessor> tasks, List<String> fileList) {
		for (FolderProcessor item : tasks) {
			fileList.addAll(item.join());
		}
	}

}
