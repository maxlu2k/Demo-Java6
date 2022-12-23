const app = angular.module("app",[]);
let list = [];
app.controller("controller",function($scope){
    $scope.import =function(files){
        let reader = new FileReader();
        reader.onloadend = async () =>{
            let workbook = new ExcelJS.Workbook();
            await workbook.xlsx.load(reader.result);
            const worksheet = workbook.getWorksheet("Sheet1");
            console.log({worksheet})
            worksheet.eachRow((row,index)=>{
                if(index>1){
                    let student = {
                        email:row.getCell(1).value,
                        fullname:row.getCell(2).value,
                        marks:+row.getCell(3).value,
                        gender:true && row.getCell(4).value,
                        contry:row.getCell(5).value,
                    }
                    list.push(student)
                }
            })
        }
        reader.readAsArrayBuffer(files[0]);
    };
})
function check(){
    console.log("a");
    for (const key in list) {
    console.log(list[key])
}
}