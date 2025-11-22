public class Demo {
	 public static void main(String[] args) {
		 Depot lahore = new Depot("Lahore Depot", 4);
		 Rack rack1 = new Rack("LR-1", new int[]{3, 4, 3});
		 lahore.addRack(rack1); // [5]
		 System.out.println("Initial layout:");
		 lahore.printAllLayouts();
		 Parcel r1 = new Parcel("PKX-2025-000111", Type.REGULAR);
		 Parcel r2 = new Parcel("PKX-2025-000222", Type.REGULAR);
		 Parcel f1 = new Parcel("PKX-2025-000333", Type.FRAGILE);
		 System.out.println("Store r1 into R3-S02: " + lahore.store("R3-S02", r1));// [5]
		 System.out.println("Attempt to store r2 into SAME R3-S02 (should fail): "
		 + lahore.store("R3-S02", r2));
		 Parcel removed = lahore.remove("R3-S02",r2);
		 System.out.println("Remove from R3-S02: " + (removed != null ? removed :
		"null")); // [5]
		 String target = lahore.findFirstEmptySlot();
		 System.out.println("First empty slot (policy): " + target);
		 System.out.println("Store FRAGILE at " + target + ": " +
		lahore.store(target, f1)); // [5]
		 System.out.println("\nCurrent layout after actions:");
		 lahore.printAllLayouts();
		 Parcel[] frags = rack1.getParcelsByType(Type.FRAGILE); // [5]
		 System.out.println("FRAGILE in rack " + rack1.getRackId() + ": " +
		frags.length);
		 for (Parcel p : frags) System.out.println(" - " + p);
		 int[] totals = lahore.getTotals();
		 System.out.println("Depot totals: Capacity=" + totals[0] + ", Occupied=" +
		totals[1]);
	 }
}