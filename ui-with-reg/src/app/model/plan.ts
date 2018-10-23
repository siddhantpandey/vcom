import { User } from './user';

export class Plan {
  private serviceId: number;

  private services: string;

  private plans: string;

  private packages: string;

  private dateOfActivation: String;

  private customer: User;

  public setDate(dateOfActivation: String) {
    this.dateOfActivation = dateOfActivation;
  }
  public setCustomer(user: User) {
    this.customer = user;
  }
}
