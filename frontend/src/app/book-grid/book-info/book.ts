import {Feedback} from "./feedback";

export class Book {
  id: number;
  book_name: string;
  thumbnail_url: string;
  author: string;
  rating: number;
  page_count: number;
  subtitle: string;
  genre: string[];
  description: string;
  feedbacks: Feedback[];
}
