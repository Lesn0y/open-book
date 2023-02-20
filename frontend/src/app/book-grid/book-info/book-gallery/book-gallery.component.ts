import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-book-gallery',
  templateUrl: './book-gallery.component.html',
  styleUrls: ['./book-gallery.component.css']
})
export class BookGalleryComponent {
  @Input() gallery: string[];
  currentIndex = 0;

  switchIndex(index: number) {
    this.currentIndex = index;
  }
}
