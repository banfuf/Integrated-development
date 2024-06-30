package NASA;

import java.util.Map;

public class MerUserTasklnfoEntity {
	public void updataTaskStatus(Map<String, Object> param) {
		String merCode = param.get("merCode") + "";
		MerUserTasklnfoEntity userTask = new MerUserTasklnfoEntity();
		userTask.setMerCode(merCode);

	}

	private void setMerCode(String merCode) {
		// TODO Auto-generated method stub

	}
}
