import { HostListener, Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'medmor_frontend';

  @HostListener('window:scroll', ['$event'])
  onScroll(event: any) {
    this.reveal();
    console.log("scrolling");
  }



  private reveal() {

    var reveals = document.querySelectorAll('.reveal');

    for (var i = 0; i < reveals.length; i++) {

      var windowHeight = window.innerHeight;
      var revealTop = reveals[i].getBoundingClientRect().top;
      var revealPoint = 100;

      if (revealTop < windowHeight - revealPoint) {

        reveals[i].classList.add('active');
      } else {
        reveals[i].classList.remove('active');
      }
    }
  }
}
