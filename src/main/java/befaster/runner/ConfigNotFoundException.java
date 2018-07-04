package befaster.runner;

public class ConfigNotFoundException extends Exception {
  static final long serialVersionUID = -1547800106193663275L;

  ConfigNotFoundException(String message) {
    super(message);
  }
}
