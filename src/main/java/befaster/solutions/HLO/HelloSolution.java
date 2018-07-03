package befaster.solutions.HLO;

import befaster.runner.SolutionNotImplementedException;

public class HelloSolution {
    public String hello(String friendName) {
        if (friendName == null || friendName.trim().length == 0) {
            return "Hello, World!";
        }
        return "Hello, {0}!".format(friendName);
    }
}
