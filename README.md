# aspireapp
Login Test: run:-> public void loginByEmail()
InventoryTest:run -> public void InventoryFeatures()
ManufacturingTest: run -> public void ManufacturingFeature()
Data: 
  input: StageEnvTestData.json
Pages: 
  - HomePage
  - InventoryPage
  - LoginPage
  - ManufacturingPage
  - ProductPage

Common
  - Constants
  - TestConstant

Drivers: "webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver96"
