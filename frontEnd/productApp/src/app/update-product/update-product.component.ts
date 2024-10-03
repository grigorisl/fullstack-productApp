import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrl: './update-product.component.css'
})
export class UpdateProductComponent implements OnInit {

  id!: number;
  product!: Product;
  submitted = false;

  constructor(private route: ActivatedRoute, private router: Router,
    private productService: ProductService) { }

  ngOnInit(): void {
    this.product = new Product();

    this.id = this.route.snapshot.params['id'];

    this.productService.getProduct(this.id)
      .subscribe(data => {
        console.log(data)
        this.product = data;
      }, error => console.log(error));
  }

  updateProduct() {
      this.productService.updateProduct(this.product)
        .subscribe(data => { console.log(data);
      this.gotoList();
    }, error => console.log(error));
  }

  onSubmit() {
    this.updateProduct();
  }

  gotoList() {
    this.router.navigate(['/products']);
  }

}
