import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-products',
  templateUrl: './show-products.component.html',
  styleUrl: './show-products.component.css'
})
export class ShowProductsComponent implements OnInit {

  products!: Observable<Product[]>;

  constructor(private productService: ProductService, private router: Router) {}

  ngOnInit(): void {
    this.fetchProductList();
  }

  fetchProductList() {
    this.products = this.productService.getProductList();
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id)
      .subscribe(
        data => {
          console.log(data);
          this.fetchProductList();
        },
        error => console.log(error)
      );
  }

  productDetails(id: number) {
    this.router.navigate(['details', id]);
  }

  updateProduct(product: Product) {
    this.router.navigate(['update', product])
  }

}
