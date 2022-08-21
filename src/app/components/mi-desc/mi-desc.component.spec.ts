import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiDescComponent } from './mi-desc.component';

describe('MiDescComponent', () => {
  let component: MiDescComponent;
  let fixture: ComponentFixture<MiDescComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MiDescComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MiDescComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
