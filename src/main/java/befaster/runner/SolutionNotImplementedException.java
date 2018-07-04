package befaster.runner;

public class SolutionNotImplementedException extends RuntimeException {
  static final long serialVersionUID = -2300134362278452064L;

  public SolutionNotImplementedException() {
    super("Solution not implemented");
  }
}
