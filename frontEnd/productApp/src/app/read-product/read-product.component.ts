import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-read-product',
  templateUrl: './read-product.component.html',
  styleUrl: './read-product.component.css'
})
export class ReadProductComponent implements OnInit{

  id!: number;
  product!: Product;

  constructor(private route: ActivatedRoute, private router: Router,
    private productService: ProductService) {}

  ngOnInit(): void {
    this.product = new Product();

    this.id = this.route.snapshot.params['id'];

    this.productService.getProduct(this.id)
      .subscribe(data => {
        console.log(data)
        this.product = data;
      }, error => console.log(error));    
  }

  list() {
    this.router.navigate(['products'])
  }

}
