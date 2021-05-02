package seleniumAssignments;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (counter != 3) {
			counter++;
			System.out.println("Retry count is :" + counter);
			return false;
		}
		return true;
	}
}
