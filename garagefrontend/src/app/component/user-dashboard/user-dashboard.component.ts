import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { VehicleService } from '../../service/vehicle-service.service';
import { SessionService } from '../../service/session.service';
import { Vehicle } from 'src/app/model/vehicle';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  vehicleSelect: FormGroup;
  vehicleForm: FormGroup;
  selectedVehicle: Vehicle;
  userVehicles: Vehicle[];
  actualForm: String;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private router: Router,
    private vehicleService: VehicleService,
    private sessionService: SessionService
    ) { }

  ngOnInit(): void {
    this.sessionService.checkSession(true);

    this.vehicleService.findUserVehicles(JSON.parse(this.sessionService.getUserId()!))
      .subscribe(data=>{
        this.userVehicles = data.result;
    })

    this.vehicleSelect = this.formBuilder.group({
      vehicle: ['', Validators.required]
    });

    this.vehicleForm = this.formBuilder.group({
      vehicle_model: [{value:'', disabled: true}, Validators.required],
      vehicle_make: [{value:'', disabled: true}, Validators.required],
      vehicle_licence: [{value:'', disabled: true}, Validators.required],
      vehicle_type: [{value:'', disabled: true}, Validators.required],
      vehicle_booking_service_type: [{value:'', disabled: true}, Validators.required],
      vehicle_booking_service_cost: [{value:'', disabled: true}, Validators.required],
      vehicle_comment: [{value:'', disabled: true}, Validators.required],
    });

    this.selectedVehicle = new Vehicle();

    this.actualForm = "vehicles";
  }

  setActualForm(a: String){
    this.actualForm = a;
  }

  getActualForm(){
    return this.actualForm;
  }

  changeVehicle(event: any) {
    //this.selectedVehicle = this.vehicleSelect.controls.vehicle.value;
    this.vehicleForm.setValue({
      ["vehicle_model"]: this.vehicleSelect.controls.vehicle.value.model.model_name,
      ["vehicle_make"]: this.vehicleSelect.controls.vehicle.value.model.make.make_name,
      ["vehicle_licence"]: this.vehicleSelect.controls.vehicle.value.vehicle_licence,
      ["vehicle_type"]: this.vehicleSelect.controls.vehicle.value.vehicle_type,
      ["vehicle_booking_service_type"]: this.vehicleSelect.controls.vehicle.value.booking_service.booking_service_type,
      ["vehicle_booking_service_cost"]: this.vehicleSelect.controls.vehicle.value.booking_service.booking_service_cost,
      ["vehicle_comment"]: this.vehicleSelect.controls.vehicle.value.vehicle_comment
    })
  }
}
