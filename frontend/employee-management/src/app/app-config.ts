export class AppConfig {
  private static appUrl = 'http://localhost:8083/';
  static getUrl(path: string): string {
    return this.appUrl + path;
  }
}
