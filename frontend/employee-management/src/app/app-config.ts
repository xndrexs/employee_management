export class AppConfig {
  private static appUrl: String = 'http://localhost:8083/';
  static getUrl(path: String): String {
    return this.appUrl + path;
  }
}
