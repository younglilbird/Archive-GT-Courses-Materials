public class DogDriver{
	public static void main(String[] args) {
		Dog d1 = new Dog("John","Husky");
		Vet v1 = new Vet();
		Vet v2 = new Vet();
		System.out.println(v1.equals(v2));
		Vet v3 = new Vet("k", null, 2);
		Vet v4 = new Vet("k", d1, 2);
		System.out.println(v3.equals(v4));
	}
}