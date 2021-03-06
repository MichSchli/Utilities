package IO;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ExtendedFileHandler implements IFileHandler {

	private IFileHandler _fileHandler;

	public ExtendedFileHandler(IFileHandler fileHandler) {
		this._fileHandler = fileHandler;
	}

	public List<List<String>> readSegments(String filename) throws FileNotFoundException {
		ArrayList<List<String>> list = new ArrayList<List<String>>();
		list.add(new ArrayList<String>());

		for (String line : _fileHandler.readLines(filename)) {
			String stripped = line.trim();

			List<String> latest = list.get(list.size() - 1);
			if (stripped.isEmpty()) {
				if (!latest.isEmpty()) {
					list.add(new ArrayList<String>());
				}
			} else {
				latest.add(stripped);
			}
		}

		return list;
	}

	public List<String> readLines(String filename) throws FileNotFoundException {
		return _fileHandler.readLines(filename);
	}

}
