import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogoArgComponent } from './logo-arg.component';

describe('LogoArgComponent', () => {
  let component: LogoArgComponent;
  let fixture: ComponentFixture<LogoArgComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogoArgComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LogoArgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
